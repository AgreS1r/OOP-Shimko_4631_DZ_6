import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Stream {
    private List<StudyGroup> groups;

    public Stream() {
        groups = new ArrayList<>();
    }

    public void addGroup(StudyGroup group) {
        groups.add(group);
    }

    public Iterator<StudyGroup> iterator() {
        return groups.iterator();
    }
}

class StreamComparator implements Comparator<Stream> {
    public int compare(Stream s1, Stream s2) {
        return s1.groups.size() - s2.groups.size();
    }
}

class StreamService {
    public void sortStreams(List<Stream> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}

class Controller {
    private StreamService streamService;

    public Controller() {
        streamService = new StreamService();
    }

    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }
}
