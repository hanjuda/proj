package action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {};
	
	public static ActionFactory getActionFactory() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		switch(command) {
		case "signInAction":
			action = new SignInAction();
			break;
		case "main":
			action = new MainAction();
			break;
		case "signUp":
			action = new SignUpAction();
			break;
		case "signUpAction":
			action = new JoinSignUpAction();
			break;
		case "signOut":
			action = new SignOutAction();
			break;
		case "buy":
			action = new BuyAction();
			break;
		case "addPoint":
			action = new AddPointAction();
			break;
		case "manager":
			action = new ManagerAction();
			break;
		case "delete":
			action = new DeleteAction();
			break;
		case "update":
			action = new UpdataAction();
			break;
		case "updateAction":
			action = new ResultUpdataAction();
			break;
		}
		return action;
	}
}
