package taxApp.menu;

import java.util.Stack;
import taxApp.util.Prompt;

public class MenuItem extends AbstractMenu{
  private MenuHandler menuHandler;

  public MenuItem( String title, Stack<String> stack){
    super(stack, title);
  }

  public MenuItem( String title, Stack<String> stack,MenuHandler menuHandler ){
    this(title, stack);
    this.menuHandler = menuHandler;
  }

  @Override
  public void execute(Prompt prompt) {
    if( menuHandler != null ){
      try{
        menuHandler.action(this);
      }catch (Exception e){
        System.out.println("실행 오류");
      }
    }
  }
}
