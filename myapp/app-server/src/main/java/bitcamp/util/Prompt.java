package bitcamp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.util.Stack;

public class Prompt implements AutoCloseable {

  Stack<String> stack = new Stack<>();

  private DataInputStream in;
  private DataOutputStream out;
  private StringWriter stringWriter = new StringWriter();
  private PrintWriter writer = new PrintWriter(stringWriter);

  public Prompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public String input(String title, Object... args) {
    try {
      printf(title, args);
      end();
      return in.readUTF();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(this.input(title, args));
  }

  public float inputFloat(String title, Object... args) {
    return Float.parseFloat(this.input(title, args));
  }

  public boolean inputBoolean(String title, Object... args) {
    return Boolean.parseBoolean(this.input(title, args));
  }

  public Date inputDate(String title, Object... args) {
    return Date.valueOf(this.input(title, args));
  }

  public void print(String str) {
    writer.print(str);
  }

  public void println(String str) {
    writer.println(str);
  }

  public void printf(String str, Object... args) {
    writer.printf(str, args);
  }

  public void end() throws Exception {
    // PrintWriter를 통해 출력한 내용은 StringWriter에 쌓여있다.
    // StringWriter에 쌓여있는 문자열을 꺼낸다.
    StringBuffer buf = stringWriter.getBuffer();
    String content = buf.toString();
    // StringWriter에 쌓여있는 문자열을 꺼낸 후 버퍼를 다시 0으로 초기화
    buf.setLength(0);

    // 버퍼에서 꺼낸 문자열을 클라이어트로 전송
    // 서버의 응답이 완료
    out.writeUTF(content);
  }

  public void close() throws Exception {
    writer.close();
    stringWriter.close();
  }

  public void pushPath(String path) {
    stack.push(path);
  }

  public String popPath() {
    return stack.pop();
  }

  public String getFullPath() {
    return String.join("/", stack.toArray(new String[0]));
  }
}
