/*
 * This file is part of Configura, developed by Arctyll (© 2023 - 2024).
 *
 * Configura is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Configura is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Configura. If not, see <https://www.gnu.org/licenses/>.
 */

package org.arctyll.configura.renderer;

import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL2;
import org.lwjgl.nanovg.NanoVGGLES2;
import org.arctyll.configura.utils.PlatformUtils;
import org.lwjgl.nanovg.NVGColor;

public class NanoVGManager {

    private static long vg;
    private static boolean android = PlatformUtils.isAndroid();

    public static void init() {
        android = System.getProperty("os.name").toLowerCase().contains("android");

        vg = android
            ? NanoVGGLES2.nvgCreate(NanoVGGLES2.NVG_ANTIALIAS | NanoVGGLES2.NVG_STENCIL_STROKES)
            : NanoVGGL2.nvgCreate(NanoVGGL2.NVG_ANTIALIAS | NanoVGGL2.NVG_STENCIL_STROKES);

        if (vg == 0) {
            throw new RuntimeException("Could not initialize NanoVG context.");
        }

        System.out.println("[NanoVGManager] Initialized with " + (android ? "OpenGL ES2" : "OpenGL 2") + " backend.");
    }

    public static long getVG() {
        return vg;
    }

    public static boolean isAndroid() {
        return android;
    }

    public static void beginFrame(int width, int height, float devicePixelRatio) {
        NanoVG.nvgBeginFrame(vg, width, height, devicePixelRatio);
    }

    public static void endFrame() {
        NanoVG.nvgEndFrame(vg);
    }

    public static void beginPath() {
        NanoVG.nvgBeginPath(vg);
    }

    public static void fill() {
        NanoVG.nvgFill(vg);
    }

    public static void destroy() {
        if (vg != 0) {
            if (android) {
                NanoVGGLES2.nvgDelete(vg);
            } else {
                NanoVGGL2.nvgDelete(vg);
            }
            vg = 0;
        }
    }
}
