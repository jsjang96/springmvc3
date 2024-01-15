package hello.itemservice.web.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // 이걸 붙이면 final에 관련된 method를 생성해줌
public class BasicItemController {
	
	private final ItemRepository itemRepository;
	
	@GetMapping
	public String items(Model model) {
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "basic/items";
	}
	
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 10000, 10));
		itemRepository.save(new Item("itemB", 20000, 20));
		
	}
	
//	@Autowired //생성자가 하나만 잇으면 생략 가능
//	public BasicItemController(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
	
}

