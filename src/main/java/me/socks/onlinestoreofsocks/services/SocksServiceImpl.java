package me.socks.onlinestoreofsocks.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.socks.onlinestoreofsocks.model.Socks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class SocksServiceImpl implements SocksService {

    private final FileService fileService;
    private int id = 0;
    private Map<Integer, Socks> socksMap = new TreeMap<>();

    public SocksServiceImpl(FileService fileService) {
        this.fileService = fileService;

    }


    public void addSocks(Socks socks) {
        socksMap.put(id++ , socks);
        saveToFIle();

    }

    public Socks getSocks(int id) {return socksMap.get(this.id);
    }

    public ResponseEntity<Socks> editSocks(int id, Socks socks) {
        if (socksMap.containsKey(id)) {
            socksMap.put(id, socks);
            return ResponseEntity.notFound().build();

        }saveToFIle();
        return null;

    }

    public boolean deleteSocks(int id) {
        socksMap.remove(id);
        return true;
    }

    private void saveToFIle() {
        try {
            String json = new ObjectMapper().writeValueAsString(socksMap);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = fileService.readFromFile();
        try {
            socksMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Socks>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
//
//    @PostConstruct
//    private void init() {
//        readFromFile();
//    }


}
