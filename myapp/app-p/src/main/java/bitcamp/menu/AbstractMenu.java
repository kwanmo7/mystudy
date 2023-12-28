package bitcamp.menu;

import bitcamp.util.Stack;

public abstract class AbstractMenu implements Menu {

  protected Stack<String> stack;
  protected String title;

  public AbstractMenu(String title, Stack<String> stack) {
    this.stack = stack;
    this.title = title;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMenuTitle() {
    return String.join("/", stack.toArray(new String[0]));
  }
}
