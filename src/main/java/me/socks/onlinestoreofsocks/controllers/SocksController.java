package me.socks.onlinestoreofsocks.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.socks.onlinestoreofsocks.model.Socks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.socks.onlinestoreofsocks.services.SocksServiceImpl;



@RequestMapping("/sock")
@RestController
public class SocksController {

    private final SocksServiceImpl socksService;

    public SocksController(SocksServiceImpl socksService) {
        this.socksService = socksService;
    }

    @Operation(description = "Добавление одной пары носков ")
    @PostMapping("/addSocks")
    public void addSocks(Socks socks) {
        socksService.addSocks(socks);

    }

    @Operation(description = "Получение пары носков по id")
    @GetMapping("/getSocks")
    public Socks getSocks(int id) {

        return socksService.getSocks(id);
    }
    @Operation(description = "Изменение пары носков по id")
    @PutMapping("/{id}")
    public Socks editSocks(int id, Socks socks) {
        return socksService.editSocks(id, socks).getBody();
    }

    @Operation(description = "Удаление пары носков по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocks(@PathVariable int id) {
        if (socksService.deleteSocks(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }


}
