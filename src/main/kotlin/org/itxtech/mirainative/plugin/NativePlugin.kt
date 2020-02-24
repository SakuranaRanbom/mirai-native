package org.itxtech.mirainative.plugin

import java.io.File

/*
 *
 * Mirai Native
 *
 * Copyright (C) 2020 iTX Technologies
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author PeratX
 * @website https://github.com/iTXTech/mirai-native
 *
 */
data class NativePlugin(val file: File, val id: Int) {
    var api: Int = -1
    var identifier: String = file.name
    val appDir: File by lazy {
        File(file.parent + File.separatorChar + identifier).also { it.mkdir() }
    }

    fun setInfo(i: String) {
        val parts = i.split(",")
        if (parts.size == 2) {
            api = parts[0].toInt()
            identifier = parts[1]
        }
    }
}
