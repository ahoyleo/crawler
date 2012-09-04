package liu.haishan.BBS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Post
{
  private String posterId;
  private String posterNick;
  private Calendar time;
  private String title;
  private String content;
  private Post parent;
  private List<Post> replies;

  public String getPosterId()
  {
    return posterId;
  }
  public void setPosterId(String posterId)
  {
    this.posterId = posterId;
  }
  public String getPosterNick()
  {
    return posterNick;
  }
  public void setPosterNick(String posterNick)
  {
    this.posterNick = posterNick;
  }
  public Calendar getTime()
  {
    return time;
  }
  public void setTime(Calendar time)
  {
    this.time = time;
  }
  public String getTitle()
  {
    return title;
  }
  public void setTitle(String title)
  {
    this.title = title;
  }
  public String getContent()
  {
    return content;
  }
  public void setContent(String content)
  {
    this.content = content;
  }
  public Post getParent()
  {
    return parent;
  }
  public void setParent(Post parent)
  {
    this.parent = parent;
  }
  public List<Post> getReplies()
  {
    return replies;
  }
  public void setReplies(List<Post> replies)
  {
    this.replies = replies;
  }

  public void addReply(Post post) {
    if (replies == null)
      replies = new ArrayList<Post>();
    replies.add(post);
  }
}
