/**
 * This file is part of Kowy Engine.
 *
 * Kowy Engine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kowy Engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kowy Engine.  If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.
 */
/**
 * This file is part of Kowy Maker.
 *
 * Kowy Maker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kowy Maker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kowy Maker.  If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.
 */
package com.kokakiwi.engine.utils;

import java.io.File;

public class SystemUtils
{
    public static OS getSystemOS()
    {
        return OS.getOSFromString(System.getProperty("os.name"));
    }
    
    public static Arch getSystemArch()
    {
        return Arch.getArchFromString(System.getProperty("os.arch"));
    }
    
    public static String getSystemVersion()
    {
        return System.getProperty("os.version");
    }
    
    public static File getExecDirectory()
    {
        return new File(getExecDirectoryPath());
    }
    
    public static String getExecDirectoryPath()
    {
        String name = SystemUtils.class.getName().replace('.', '/');
        name = SystemUtils.class.getResource("/" + name + ".class").toString();
        if (name.contains(".jar"))
        {
            name = name.substring(0, name.indexOf(".jar"));
            name = name.substring(name.lastIndexOf(':') + 1,
                    name.lastIndexOf('/') + 1).replace('%', ' ');
            String s = "";
            for (int i = 0; i < name.length(); i++)
            {
                s += name.charAt(i);
                if (name.charAt(i) == ' ')
                {
                    i += 2;
                }
            }
            
            return s.replace('/', File.separatorChar);
        }
        else
        {
            name = SystemUtils.class.getProtectionDomain().getCodeSource()
                    .getLocation().getPath();
            name = name.replace('%', ' ');
            String s = "";
            for (int i = 0; i < name.length(); i++)
            {
                s += name.charAt(i);
                if (name.charAt(i) == ' ')
                {
                    i += 2;
                }
            }
            
            return s.replace('/', File.separatorChar);
        }
    }
    
    public enum OS
    {
        windows("Windows", "\r\n", "win"), linux("Linux", "\n", "linux"), macosx(
                "Mac OS", "\n", "mac"), solaris("Solaris", "\n", "sunos",
                "solaris"), unknown;
        
        private final String   name;
        private final String[] labels;
        private final String   lineSeparator;
        
        OS()
        {
            this("Unknown");
        }
        
        OS(String name)
        {
            this(name, "\n");
        }
        
        OS(String name, String lineSeparator, String... strings)
        {
            this.name = name;
            this.lineSeparator = lineSeparator;
            labels = strings;
        }
        
        public String getName()
        {
            return name;
        }
        
        public String getLineSeparator()
        {
            return lineSeparator;
        }
        
        public static OS getOSFromString(String name)
        {
            for (final OS os : values())
            {
                for (final String label : os.labels)
                {
                    if (name.toLowerCase().contains(label.toLowerCase()))
                    {
                        return os;
                    }
                }
            }
            
            return unknown;
        }
    }
    
    public enum Arch
    {
        x86("x86"), amd64("amd64"), unknown;
        
        private final String[] labels;
        
        Arch(String... strings)
        {
            labels = strings;
        }
        
        public String getName()
        {
            return name();
        }
        
        public static Arch getArchFromString(String name)
        {
            for (final Arch os : values())
            {
                for (final String label : os.labels)
                {
                    if (name.toLowerCase().contains(label.toLowerCase()))
                    {
                        return os;
                    }
                }
            }
            
            return unknown;
        }
    }
}
