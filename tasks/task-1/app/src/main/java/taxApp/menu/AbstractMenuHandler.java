package taxApp.menu;

import taxApp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler{

  protected Prompt prompt;
  protected Menu menu;

  public AbstractMenuHandler(Prompt prompt, Menu menu) {
    this.prompt = prompt;
    this.menu = menu;
  }
  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    printMenu(menu.getTitle());
    this.menu = menu;
    action();
  }

  private void printMenu(String title){

  }
  protected abstract void action();
}
