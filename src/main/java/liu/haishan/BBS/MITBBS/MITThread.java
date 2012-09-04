package liu.haishan.BBS.MITBBS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MITThread
{
  protected final String POST_START_LINE = "^\\[ \\d+ \\]";
  protected final String POST_END_LINE = "※ 来源:";
  protected final String POST_PATTERN = POST_START_LINE + "(.*)" + POST_END_LINE;
  protected final Pattern POST_START_PATTERN = Pattern.compile(POST_START_LINE);

  boolean postStarted = false;

  public void parseLine(String rawLine) {
    rawLine.indexOf("");
    boolean posterParsed = false;
    boolean boardParsed = false;
    boolean titleParsed = false;
    boolean siteParsed = false;
    boolean dateParsed = false;
    boolean contentParsed = false;

    if (!postStarted) {
      Matcher matcher = POST_START_PATTERN.matcher(rawLine);
//      System.out.println(rawLine);

      if (matcher.matches()) {
        postStarted = true;
        System.out.println("POST:");
      }
    }
    else {
      if (!rawLine.startsWith(POST_END_LINE))
        System.out.println(rawLine);
      else
        postStarted = false;
    }
  }

  public static void main(String [] args) {
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader("sample_post"));
      String line;
      MITThread thread = new MITThread();
      while ((line = reader.readLine()) != null) {
        thread.parseLine(line);
      }
    }
    catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
