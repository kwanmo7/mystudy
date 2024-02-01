package taxApp.menu;

import java.util.Stack;

public abstract class AbstractMenu implements Menu{
  protected Stack<String> stack;
  String title;

  public AbstractMenu(Stack<String> stack, String title) {
    this.stack = stack;
    this.title = title;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  public String getMenuPath(){
    return String.join("/",stack.toArray(new String[0]));
  }
}
