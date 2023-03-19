package me.socks.onlinestoreofsocks.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    private String socksColor;
    private int sockSize;
    private int compositionOfSocks;
    private String availability;
}
