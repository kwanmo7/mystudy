package bitcamp.menu;

import bitcamp.util.LinkedList;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import bitcamp.util.Stack;

// Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();

  private MenuGroup(String title, Stack<String> stack) {
    super(title, stack);
  }

  public static MenuGroup getInstance(String title) {
    return new MenuGroup(title, new Stack<String>());
  }

  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의하겠다고 컴파일러에게 알린다.
  public void execute(Prompt prompt) {
    this.printMenu();
    stack.push(title);
    while (true) {
      String input = prompt.input("%s> ", getMenuTitle());

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      try {
        int menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menus.size()) {
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }

        this.menus.get(menuNo - 1).execute(prompt);

      } catch (Exception e) {
        System.out.println("메뉴가 옳지 않습니다!");
      }
    }
    stack.pop();
  }

  private void printMenu() {
    System.out.printf("[%s]\n", this.getTitle());

    for (int i = 0; i < this.menus.size(); i++) {
      System.out.printf("%d. %s\n", (i + 1), menus.get(i).getTitle());
    }

    System.out.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public MenuItem addMenuItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, stack, handler);
    add(menuItem);
    return menuItem;
  }

  public MenuGroup addMenuGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title, this.stack);
    add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }
}
