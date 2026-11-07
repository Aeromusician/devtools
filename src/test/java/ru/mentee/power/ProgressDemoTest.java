package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ProgressDemoTest {

  @Test
  void shouldPrintProgressInformation() {
    var output = new ByteArrayOutputStream();
    var originalOut = System.out;
    System.setOut(new PrintStream(output));
    try {
      ProgressDemo.main(new String[]{});
      var consoleOutput = output.toString();
      assertTrue(consoleOutput.contains("Nikita Naumov"));
    } finally {
      System.setOut(originalOut);
    }
  }
}