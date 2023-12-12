package bitcamp.myapp.handler.Help;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class HelpHandler implements MenuHandler {

  String title;
  Prompt prompt;

  public HelpHandler(String title) {
    this.title = title;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.RESET, menu.getTitle());
    System.out.printf("%s", this.title);
  }
}
