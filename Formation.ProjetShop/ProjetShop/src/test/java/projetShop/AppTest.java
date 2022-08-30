package projetShop;

import projetShop.util.Context;

public class AppTest {
	public static void main(String[] args) {
			Context.getEntityManagerFactory();
			Context.destroy();
	}
}
