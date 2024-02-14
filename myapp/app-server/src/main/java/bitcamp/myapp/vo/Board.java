package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Board implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;
  private String writer;
  private Date createdDate;
  private int fileCount;
  private List<AttachedFile> files;

  public static Board createFromCsv(String csv) {
    String[] values = csv.split(",");
    Board obj = new Board();
    obj.setTitle(values[0]);
    obj.setContent(values[1]);
    obj.setWriter(values[2]);
    obj.setCreatedDate(new Date(Long.valueOf(values[3])));
    return obj;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }


  @Override
  public String toString() {
    return "Board{" +
        "no=" + no + '\'' +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", writer='" + writer + '\'' +
        ", createdDate=" + createdDate +
        ", files='" + files +
        ", fileCount='" + fileCount +
        '}';
  }

  public List<AttachedFile> getFiles() {
    return files;
  }

  public void setFiles(List<AttachedFile> files) {
    this.files = files;
  }

  public int getFileCount() {
    return fileCount;
  }

  public void setFileCount(int fileCount) {
    this.fileCount = fileCount;
  }
}
