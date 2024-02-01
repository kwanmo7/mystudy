package taxApp.menu;

import taxApp.util.Prompt;

public interface Menu {
  void execute(Prompt prompt);

  String getTitle();
}
