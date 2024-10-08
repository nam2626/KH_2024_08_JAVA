package e03_constructor;
/*
 * 		데이터
 * 			음량 - int, 채널 - int, 전원 - boolean, 음소거 - boolean
 * 			음량 데이터 범위 : 0 ~ 50
 * 			채널 데이터 범위 : 1 ~ 766
 * 			전원 : true - ON, false - OFF
 * 			음소거 : true - ON, false - OFF
		기능
		    전원OnOff
		    음량Up / 음량 Down
		    채널Up / 채널 Down
		    음소거OnOff
 */
public class TV {
	boolean power;
	boolean mute;
	int channel;
	int volume;
	final int MAX_CHANNEL = 766;
	final int MIN_CHANNEL = 1;
	final int MAX_VOLUME;
	final int MIN_VOLUME = 0;

	TV(){
		//초기화
		channel = 24;
		volume = 10;
		//final로 선언된 필드는 선언시 초기화를 안한다면
		//생성자에서 반드시 초기화 시켜줘야됨
		MAX_VOLUME = 60;
	}
	
	void powerOnOff() {
		//메서드를 실행 할때마다 전원이 켜졌다가 꺼졌다가 해야함
		power = !power;
		//전원 값이 true --> TV 전원 On
		if(power) System.out.println("TV 전원 On");
		//전원 값이 false --> TV 전원 Off
		else System.out.println("TV 전원 Off");
	}
	
	//채널Up ==> 채널값 증가, 최대값에 증가하면 첫번째 채널로 이동, 옮긴 채널값을 출력
	void channelUp() {
		if(!power) return;
		//메서드 실행시 채널 1씩 증가  %    +    =
		//채널이 값이 최대값일떄 증가하면 1번으로 이동
		channel = channel % MAX_CHANNEL + 1; 
		//현재 채널 번호 출력
		System.out.println("현재 채널 : " + channel);
	}
	
	//채널Down ==> 채널값 감소, 최소값에 감소하면 마지막 채널로 이동, 옮긴 채널값을 출력
	void channelDown() {
		if(!power) return;
		
		channel = channel == MIN_CHANNEL ? MAX_CHANNEL : channel - 1;
		System.out.println("현재 채널 : " + channel);
	}
	
	//음소거OnOff 
	void muteOnOff() {
		if(!power) return;
		mute = !mute;
		System.out.println(mute ? "음소거 적용" : "음소거 해제");
	}
	
	void volumeUp() {
		if(!power) return;
		if(mute) muteOnOff();
		
		if(volume < MAX_VOLUME)
			volume++;
		
		System.out.println("현재 음량 : " + volume);
		
	}
	void volumeDown() {
		if(!power) return;
		if(mute) muteOnOff();
		
		if(volume > MIN_VOLUME)
			volume--;
		
		System.out.println("현재 음량 : " + volume);
		
	}
}







