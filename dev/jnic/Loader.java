package dev.jnic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Loader {
    public static void init() {
    }

    static {
        File file;
        String string = System.getProperty((String)"os.name").toLowerCase();
        String string2 = System.getProperty((String)"os.arch").toLowerCase();
        String string3 = null;
        if (string.contains((CharSequence)"mac") && (string2.equals((Object)"x86_64") || string2.equals((Object)"amd64"))) {
            string3 = "/dev/jnic/lib/172caedb-2f18-492d-a4ff-f117a72ad02c.dat";
        }
        if (string.contains((CharSequence)"win") && string2.equals((Object)"aarch64")) {
            string3 = "/dev/jnic/lib/1fe66b69-8226-4d05-96e7-fa7e1ab93d61.dat";
        }
        if (string.contains((CharSequence)"lin") && string2.equals((Object)"aarch64")) {
            string3 = "/dev/jnic/lib/7fa65937-76f4-48e4-8858-169dd1d3f72d.dat";
        }
        if (string.contains((CharSequence)"win") && (string2.equals((Object)"x86_64") || string2.equals((Object)"amd64"))) {
            string3 = "/dev/jnic/lib/0398a626-9d71-4f82-b5fd-2c9e1d55b36b.dat";
        }
        if (string.contains((CharSequence)"mac") && string2.equals((Object)"aarch64")) {
            string3 = "/dev/jnic/lib/280f4fcc-98c7-4b48-9eef-36ad9e2a2d9e.dat";
        }
        if (string.contains((CharSequence)"lin") && (string2.equals((Object)"x86_64") || string2.equals((Object)"amd64"))) {
            string3 = "/dev/jnic/lib/b1bb8e41-61cd-44cd-9b98-a9f6636f641d.dat";
        }
        if (string3 == null) {
            throw new UnsatisfiedLinkError("Platform not supported: " + string + "/" + string2);
        }
        try {
            file = File.createTempFile((String)"lib", null);
            file.deleteOnExit();
            if (!file.exists()) {
                throw new IOException();
            }
        }
        catch (IOException iOException) {
            throw new UnsatisfiedLinkError("Failed to create temp file");
        }
        byte[] byArray = new byte[2048];
        try (InputStream inputStream = Loader.class.getResourceAsStream(string3);
             FileOutputStream fileOutputStream = new FileOutputStream(file);){
            int n;
            while ((n = inputStream.read(byArray)) != -1) {
                fileOutputStream.write(byArray, 0, n);
            }
        }
        catch (IOException iOException) {
            throw new UnsatisfiedLinkError("Failed to copy file: " + iOException.getMessage());
        }
        System.load((String)file.getAbsolutePath());
    }
}
