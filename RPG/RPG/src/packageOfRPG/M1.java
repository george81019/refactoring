package packageOfRPG;

public class M1 extends Melee {
	M3 mother;

	public M1() {
		name = "���Z�H";
		skill_n = "�J��";
		skill_s = "none";
		hp = 120;
		maxhp = 120;
		mp = 0;
		maxmp = 0;
		mp_costn = 0;
		mp_costs = 0;
		anger = 0;
		turn = 1;
		count = 1;
		type = 6;
		target = -1;
		position = -1;
		mother = null;
	}

	protected void normal_detial(Team ally) {
	}

	public void special(Team ally) {
	}

	public void normal(Team ally) {
		int atk = (int) (10 * (buff + anger * 0.05));
		System.out.println(name + "��" + ally.members[ally.number - 1].name + "�ϥ�" + skill_n);
		ridicule(ally);
		ally.members[0].damage(atk);
		ally.rearrange();
		anger = anger + 1;
		System.out.println(name + "���+1");
		if (anger == 10) {
			atk = (int) (10 * (buff + anger * 0.05));
			ally.members[0].damage(atk);
			ally.rearrange();
			reset_anger();
		}
	}

	protected void ridicule(Team ally) {
		Chara temp = ally.members[ally.number - 1];
		for (int i = ally.number - 1; i > 0; i--) {
			ally.members[i] = ally.members[i - 1];
		}
		ally.members[0] = temp;
	}
}
