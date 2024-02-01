package taxApp.menu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import taxApp.util.Prompt;

public class MenuGroup extends AbstractMenu{
  private List<Menu> menuList = new LinkedList<>();

  private MenuGroup( String title, Stack<String> stack){
    super(stack, title);
  }
  public static MenuGroup getInstance(String title){
    return new MenuGroup(title,new Stack<String>());
  }

  @Override
  public void execute(Prompt prompt) {
    stack.push(this.title);
    printMenu();
    while( true ){
      String input = prompt.input("%s>> ", getMenuPath());
      if( input.equals("menu") ){
        printMenu();
        continue;
      } else if( input.equals("0") ){
        break;
      }

      try{
        int menuNo = Integer.parseInt(input);
        if( menuNo < 1 || menuNo > menuList.size() ){
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }
        menuList.get(menuNo - 1).execute(prompt);
      }catch (Exception e){
        System.out.println("메뉴 번호가 올바르지 않습니다.");
      }
    }
    stack.pop();
  }

  private void printMenu(){
    System.out.printf( "[%s]\n", this.getTitle() );
    Iterator<Menu> iterator = menuList.iterator();
    int i = 1;
    while(iterator.hasNext()){
      Menu menu = iterator.next();
      System.out.printf( "%d. %s\n",i++,menu.getTitle() );
    }
    System.out.printf("0. %s\n", "이전");
  }
  public void add( Menu menu ){
    menuList.add(menu);
  }
  public MenuGroup addGroup(String title){
    MenuGroup menuGroup =new MenuGroup(title,stack);
    add(menuGroup);
    return menuGroup;
  }

  public MenuItem addItem(String title, MenuHandler menuHandler){
    MenuItem menuItem = new MenuItem(title,stack,menuHandler);
    add(menuItem);
    return menuItem;
  }
}
