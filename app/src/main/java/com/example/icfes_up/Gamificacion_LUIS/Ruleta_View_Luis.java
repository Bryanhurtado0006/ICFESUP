package com.example.icfes_up.Gamificacion_LUIS;

import android.animation.*;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.Random;

public class Ruleta_View_Luis extends View {

    private Paint paint;
    private RectF rectF;
    private Paint textPaint;
    private Paint borderPaint;

    private String[] categorias = {
            "Lectura Crítica", "Química", "Sociales", "Inglés", "Matemáticas", "Aleatorio"
    };

    private int[] colores = {
            Color.parseColor("#EF9A9A"),
            Color.parseColor("#90CAF9"),
            Color.parseColor("#CE93D8"),
            Color.parseColor("#EF9A9A"),
            Color.parseColor("#FFF59D"),
            Color.parseColor("#FFCC80")
    };

    private int categoriaSeleccionadaIndex = -1;
    private String categoriaSeleccionada = "";
    private float currentAngle = 0f;

    public Ruleta_View_Luis(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setColor(Color.WHITE);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(4f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();
        float radius = Math.min(width, height) / 2 - 20;

        rectF.set(width / 2 - radius, height / 2 - radius, width / 2 + radius, height / 2 + radius);
        float sweepAngle = 360f / categorias.length;

        canvas.save();
        canvas.rotate(currentAngle, width / 2, height / 2);

        for (int i = 0; i < categorias.length; i++) {
            paint.setColor(i == categoriaSeleccionadaIndex ? Color.RED : colores[i]);
            canvas.drawArc(rectF, i * sweepAngle, sweepAngle, true, paint);
            canvas.drawArc(rectF, i * sweepAngle, sweepAngle, true, borderPaint);
            drawTextOnSector(canvas, categorias[i], i * sweepAngle + sweepAngle / 2, radius);
        }

        canvas.restore();

        // Dibuja "GO" en el centro
        paint.setColor(Color.WHITE);
        canvas.drawCircle(width / 2, height / 2, 50, paint);
        textPaint.setTextSize(40);
        canvas.drawText("GO", width / 2, height / 2 + 15, textPaint);
    }

    private void drawTextOnSector(Canvas canvas, String text, float angle, float radius) {
        double radian = Math.toRadians(angle);
        float x = (float) (getWidth() / 2 + radius / 1.5 * Math.cos(radian));
        float y = (float) (getHeight() / 2 + radius / 1.5 * Math.sin(radian));

        textPaint.setTextSize(28);
        canvas.drawText(text, x, y, textPaint);
    }

    public void girarRuleta(final Runnable onStop) {
        categoriaSeleccionadaIndex = new Random().nextInt(categorias.length);
        categoriaSeleccionada = categorias[categoriaSeleccionadaIndex];

        // Animación para girar la ruleta
        ObjectAnimator rotation = ObjectAnimator.ofFloat(this, "rotation", currentAngle, currentAngle + (360 * 5) + new Random().nextInt(360));
        rotation.setDuration(5000);
        rotation.setInterpolator(new DecelerateInterpolator());
        rotation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                currentAngle = (currentAngle + 360 * 5 + new Random().nextInt(360)) % 360;
                onStop.run();
            }
        });
        rotation.start();
    }

    public String getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
}
