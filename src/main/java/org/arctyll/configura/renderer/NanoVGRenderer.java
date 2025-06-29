package org.arctyll.configura.renderer;

import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NVGColor;
import org.arctyll.configura.renderer.NanoVGManager;

import static org.lwjgl.nanovg.NanoVG.*;

public class NanoVGRenderer {

    private static final NVGColor tempColor = NVGColor.calloc();

    public static void fillColor(byte r, byte g, byte b, byte a) {
        applyColor(tempColor, r, g, b, a);
        nvgFillColor(NanoVGManager.getVG(), tempColor);
    }

    public static void strokeColor(byte r, byte g, byte b, byte a) {
        applyColor(tempColor, r, g, b, a);
        nvgStrokeColor(NanoVGManager.getVG(), tempColor);
    }

    public static void fillColor(NVGColor color) {
        nvgFillColor(NanoVGManager.getVG(), color);
    }

    public static void strokeColor(NVGColor color) {
        nvgStrokeColor(NanoVGManager.getVG(), color);
    }

    public static void drawRect(float x, float y, float w, float h) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgRect(vg, x, y, w, h);
        nvgFill(vg);
    }

    public static void drawRoundedRect(float x, float y, float w, float h, float r) {
        long vg = NanoVGManager.getVG();
        nvgRoundedRect(vg, x, y, w, h, r);
        nvgFill(vg);
    }

    public static void drawStrokeRect(float x, float y, float w, float h, float strokeWidth) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgRect(vg, x, y, w, h);
        nvgStrokeWidth(vg, strokeWidth);
        nvgStroke(vg);
    }

    public static void drawRoundedStrokeRect(float x, float y, float w, float h, float r, float strokeWidth) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgRoundedRect(vg, x, y, w, h, r);
        nvgStrokeWidth(vg, strokeWidth);
        nvgStroke(vg);
    }

    public static void drawCircle(float cx, float cy, float radius) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgCircle(vg, cx, cy, radius);
        nvgFill(vg);
    }

    public static void drawStrokeCircle(float cx, float cy, float radius, float strokeWidth) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgCircle(vg, cx, cy, radius);
        nvgStrokeWidth(vg, strokeWidth);
        nvgStroke(vg);
    }

    public static void drawLine(float x1, float y1, float x2, float y2, float strokeWidth) {
        long vg = NanoVGManager.getVG();
        nvgBeginPath(vg);
        nvgMoveTo(vg, x1, y1);
        nvgLineTo(vg, x2, y2);
        nvgStrokeWidth(vg, strokeWidth);
        nvgStroke(vg);
    }

    public static void drawText(String text, float x, float y, float fontSize, String fontName) {
        long vg = NanoVGManager.getVG();
        nvgFontSize(vg, fontSize);
        nvgFontFace(vg, fontName);
        nvgTextAlign(vg, NVG_ALIGN_LEFT | NVG_ALIGN_TOP);
        nvgText(vg, x, y, text);
    }

    private static void applyColor(NVGColor color, byte r, byte g, byte b, byte a) {
        color.r((r & 0xFF) / 255.0f);
        color.g((g & 0xFF) / 255.0f);
        color.b((b & 0xFF) / 255.0f);
        color.a((a & 0xFF) / 255.0f);
    }
}
