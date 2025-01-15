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

package org.arctyll.configura.annotations;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import org.arctyll.configura.models.Option.OptionType;

/**
 * Annotation to add a Header text in config.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Header {
	String name();
	String category();

	OptionType type() default OptionType.HEADER;
}
