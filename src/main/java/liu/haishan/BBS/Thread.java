package liu.haishan.BBS;

import java.util.ArrayList;


public class Thread {
  private Post op;

  public Thread(Post op) {
      this.op = op;
//      this.op.setReplies(new ArrayList<Post>());
  }
}
