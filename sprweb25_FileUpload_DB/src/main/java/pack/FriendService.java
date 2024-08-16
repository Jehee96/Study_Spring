package pack;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;
	
	public void saveFriend(Friend friend) {
		friendRepository.save(friend);
	}
	
	
	public List<Friend> findAll() {
		// Friend 데이터 모두 읽어 각 객체를 Base64로 변환 후, 그 결과를 리스트에 저장
		return friendRepository.findAll().stream().map(this::convertToBase64).collect(Collectors.toList());
	}
	
	
	private Friend convertToBase64(Friend friend) {
		// 사진을 Base64로 인코딩해서 DB에 저장	
		if(friend.getPic() != null && friend.getPic().length > 0) {
			String base64Image = Base64.getEncoder().encodeToString(friend.getPic());
			friend.setBase64Image(base64Image);
		}
		return friend;
	}
	
	// number 증가
	private int generateNumber() {
		Integer lastNumber = friendRepository.findLastNumber();
		if(lastNumber == null) {
			return 1;
		} else {
			return lastNumber + 2;
		}
	}
}
