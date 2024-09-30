package e05_anonyumous;

public class Player {
	private Gun gun;

	public Player(Gun gun) {
		super();
		this.gun = gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public void shot() {
		gun.shot();
	}
	
	public void reload() {
		gun.reload();
	}
	
	
}
