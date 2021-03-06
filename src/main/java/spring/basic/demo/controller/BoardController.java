package spring.basic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.basic.demo.domain.Lodging;
import spring.basic.demo.domain.Place;
import spring.basic.demo.domain.Store;
import spring.basic.demo.service.BoardService;

import java.util.List;


@Controller      //spring bean 사용하여 따로 설정했으므로 삭제해야함
public class BoardController {

    BoardService service;
    @Autowired
    public BoardController(BoardService service){         // controller와 service 연결하는 느낌

        this.service = service;
    }

    // ------------- 맛집 부분 --------------
    @GetMapping("store/new")
    public String createStore(){

        return "store/StorecreateForm";
    }

    // URL 이 변경되지 않은 상태에서 실행
    @PostMapping("store/new")
    public String createStoreData(@RequestParam("name") String name,@RequestParam("location") String location,@RequestParam("menu") String menu,@RequestParam("price") int price,@RequestParam("tag") String tag ){

        Store m = new Store();
        m.setName(name);
        m.setLocation(location);
        m.setMenu(menu);
        m.setPrice(price);
        m.setTag(tag);
        //DB에 입력한 값을 넣어야 해요.
        service.createStore(m);

        return "redirect:/";    // 제일 첫 페이지로 돌아감
    }

    @GetMapping("store/find")
    public String findStore(){

        return "store/StorefindForm";
    }

    @PostMapping("store/find")
    public String findStoreData(@RequestParam("id")int id, Model model){
        // Service를 통해서 id로 member를 찾아서
        Store m = service.showStoreById(id);

        // 찾은 객체를 통재로 다음 페이지로 넘김
        model.addAttribute("member",m);  // member라는 상자에 m객체를 넣어서 보내줌

        // 다음 페이지로 이동
        return "store/StorefindMember";
    }


    @GetMapping("store/findall")
    public String findStoreAll(Model model){
        List<Store> data = service.showStoreAll();
        model.addAttribute("data",data);

        return "store/Storefindall";
    }


    // ------------- 숙소 부분 --------------
    @GetMapping("lodging/new")
    public String createLodging(){

        return "lodging/LodgingcreateForm";
    }

    // URL 이 변경되지 않은 상태에서 실행
    @PostMapping("lodging/new")
    public String createLodgingData(@RequestParam("name") String name,@RequestParam("location") String location,@RequestParam("content") String content,@RequestParam("price") int price,@RequestParam("tag") String tag ){

        Lodging m = new Lodging();
        m.setName(name);
        m.setLocation(location);
        m.setContent(content);
        m.setPrice(price);
        m.setTag(tag);
        //DB에 입력한 값을 넣어야 해요.
        service.createLodging(m);

        return "redirect:/";    // 제일 첫 페이지로 돌아감
    }

    @GetMapping("lodging/find")
    public String findLodging(){

        return "lodging/LodgingfindForm";
    }

    @PostMapping("lodging/find")
    public String findLodgingData(@RequestParam("id")int id, Model model){
        // Service를 통해서 id로 member를 찾아서
        Lodging m = service.showLodgingById(id);

        // 찾은 객체를 통재로 다음 페이지로 넘김
        model.addAttribute("member",m);  // member라는 상자에 m객체를 넣어서 보내줌

        // 다음 페이지로 이동
        return "lodging/LodgingfindMember";
    }


    @GetMapping("lodging/findall")
    public String findLodgingAll(Model model){
        List<Lodging> data = service.showLodgingAll();
        model.addAttribute("data",data);

        return "lodging/Lodgingfindall";
    }


    // ------------- 장소 부분 --------------
    @GetMapping("place/new")
    public String createPlace(){

        return "place/PlacecreateForm";
    }

    // URL 이 변경되지 않은 상태에서 실행
    @PostMapping("place/new")
    public String createPlaceData(@RequestParam("name") String name,@RequestParam("location") String location,@RequestParam("content") String content,@RequestParam("tag") String tag ){

        Place m = new Place();
        m.setName(name);
        m.setLocation(location);
        m.setContent(content);
        m.setTag(tag);
        //DB에 입력한 값을 넣어야 해요.
        service.createPlace(m);

        return "redirect:/";    // 제일 첫 페이지로 돌아감
    }

    @GetMapping("place/find")
    public String findPlace(){

        return "place/PlacefindForm";
    }

    @PostMapping("place/find")
    public String findPlaceData(@RequestParam("id")int id, Model model){
        // Service를 통해서 id로 member를 찾아서
        Place m = service.showPlaceById(id);

        // 찾은 객체를 통재로 다음 페이지로 넘김
        model.addAttribute("member",m);  // member라는 상자에 m객체를 넣어서 보내줌

        // 다음 페이지로 이동
        return "place/PlacefindMember";
    }


    @GetMapping("place/findall")
    public String findPlaceAll(Model model){
        List<Place> data = service.showPlaceAll();
        model.addAttribute("data",data);

        return "place/Placefindall";
    }
}
