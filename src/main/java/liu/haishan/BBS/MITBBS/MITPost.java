package liu.haishan.BBS.MITBBS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import liu.haishan.BBS.Post;

public class MITPost extends Post
{
  protected final String ID_LINE_PATTERN = "^\\s+发信人: (.*)\\((.*)\\), 信区: (.*)$";
  protected final String TITLE_LINE_PATTERN = "^标  题: (.*)$";
  protected final String SITE_LINE_PATTERN = "^发信站: (.*) \\((.*), (.*)\\)$";
  protected final String PARENT_DELIM = "【";

  
  public void parse(String rawText) {
    rawText.indexOf("");
    boolean posterParsed = false;
    boolean boardParsed = false;
    boolean titleParsed = false;
    boolean siteParsed = false;
    boolean dateParsed = false;
    boolean contentParsed = false;
    
    BufferedReader reader = new BufferedReader(new StringReader(rawText));
    String line;
    try
    {
      while ((line = reader.readLine()) != null) {
        if (posterParsed == false) {
          
        }
      }
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  boolean posterIdLineParsed = false;
  boolean titleLineParsed = false;
  boolean siteLineParsed = false;
  boolean contentStarted = false;
  StringBuilder contentBuilder = new StringBuilder();
  public void parseLine(String rawLine) {
    if (posterIdLineParsed == false) {
      String pattern = "^\\s+发信人: (.*)\\((.*)\\), 信区: (.*)$";
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(rawLine);
      if (m.find()) {
        setPosterId(m.group(1));
        setPosterNick(m.group(2));
      }
      posterIdLineParsed = true;
    }
    if (titleLineParsed == false) {
      String pattern = "^标  题: (.*)$";
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(rawLine);
      if (m.find()) {
        setTitle(m.group(1));
      }
      titleLineParsed = true;
    }
    if (siteLineParsed == false) {
      String pattern = "^发信站: (.*) \\((.*), (.*)\\)$";
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(rawLine);
      if (m.find()) {
        String dateRaw = m.group(2);
        String timeZone = "";
        if (m.group(3).equals("美东"))
          timeZone = "EDT";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy, z");
        try
        {
          Date date = sdf.parse(dateRaw + ", " + timeZone);
        }
        catch (ParseException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }      }
      siteLineParsed = true;
    }
    
      
  }
  
  public static void main(String [] args) throws ParseException {
    String s1 = "    发信人: TSC (特色菜), 信区: Stock";
    String pattern = "^\\s+发信人: (.*)\\((.*)\\), 信区: (.*)$";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(s1);
    if (m.find()) {
      System.out.println(m.group(1));
      System.out.println(m.group(2));
      System.out.println(m.group(3));
    }
    String s2 = "标  题: Re: 上点干货";
    pattern = "^标  题: (.*)$";
    p = Pattern.compile(pattern);
    m = p.matcher(s2);
    if (m.find()) {
      System.out.println(m.group(1));
    }
    
    String s3 = "发信站: BBS 未名空间站 (Fri Aug 31 18:17:57 2012, 美东)";
    pattern = "^发信站: (.*) \\((.*), (.*)\\)$";
    p = Pattern.compile(pattern);
    m = p.matcher(s3);
    if (m.find()) {
      System.out.println(m.group(1));
      String dateRaw = m.group(2);
      String timeZone = "";
      if (m.group(3).equals("美东"))
        timeZone = "EDT";
      SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy, z");
      Date date = sdf.parse(dateRaw + ", " + timeZone);
      System.out.println(date.toString());
    }
    
    String s4 = "[ 1 ]";
    pattern = "^\\[ \\d+ \\]";
    p = Pattern.compile(pattern);
    m = p.matcher(s4);
    if (m.find()) {
      System.out.println(m.group());
    
    }
  }
}
