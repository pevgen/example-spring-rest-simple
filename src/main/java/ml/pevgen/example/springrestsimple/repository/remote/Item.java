package ml.pevgen.example.springrestsimple.repository.remote;

import lombok.Getter;

@Getter
public class Item {

    private String id;
    private String etag;

    // the JSON field is named volumeInfo
    private VolumeInfo volumeInfo;

}
