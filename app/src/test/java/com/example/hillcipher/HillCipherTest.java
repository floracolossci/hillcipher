package com.example.hillcipher;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.annotation.processing.SupportedSourceVersion;

import static org.junit.Assert.*;

import static com.example.hillcipher.HillCipher.Factory.getKeyMatrix;

@RunWith(JUnit4.class)
public class HillCipherTest {

    @Test
    public void test_keyLength() {
        final String invalidKey1 = "CIPHERIN";
        final String invalidKey2 = "C21";
        final String validKey = "CIPHERING";

        assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                new HillCipher.Factory().create(invalidKey1);
            }
        });

        assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                new HillCipher.Factory().create(invalidKey2);
            }
        });

        new HillCipher.Factory().create(validKey);
    }

    @Test
    public void test_getMatrixKey() {
        final String key = "CIPHERING";
        final int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        final int[][] expectedKeyMatrix = {{2, 8, 15}, {7, 4, 17}, {8, 13, 6}};
        System.out.printf("D:// key=%s%n", key);
        System.out.println("D:// generated matrix==>");
        Util.printMatrix(keyMatrix);

        assertArrayEquals("Generated key matrix matches expected", expectedKeyMatrix, keyMatrix);
    }

    @Test
    public void test_encryptionAndDecription() {
        final String message = "SAFEMESSAGE";
        final String cipherKey = "CIPHERING";

        final HillCipher algorithm = new HillCipher.Factory().create(cipherKey);
        final String cipherText = algorithm.encrypt(message);

        assertEquals("HDSIOEYQOZHE", cipherText);
    }
}