package sem451;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReserveBlockList {
    private Map<String, ReserveBlock> reserveBlocks;

    public ReserveBlockList() {
        reserveBlocks = new HashMap<>();
    }

    public void printAllReserveBlocks() {
        reserveBlocks.values().forEach(System.out::println);
    }

    public int countReserveBlocks() {
        return reserveBlocks.size();
    }

    public void clearAllReserveBlocks() {
        reserveBlocks.clear();
    }

    public boolean addReserveBlock(ReserveBlock block) {
        if (block == null) {
            return false;
        }
        String key = block.getDate() + "_" + block.getClock() + "_" + block.getRoom().getName();
        if (reserveBlocks.containsKey(key)) {
            return false;
        }
        reserveBlocks.put(key, block);
        return true;
    }

    public boolean removeReserveBlock(ReserveBlock block) {
        if (block == null) {
            return false;
        }
        String key = block.getDate() + "_" + block.getClock() + "_" + block.getRoom().getName();
        return reserveBlocks.remove(key) != null;
    }

    public ReserveBlock getReserveBlock(LocalDate date, int clock, Room room) {
        String key = date + "_" + clock + "_" + room.getName();
        return reserveBlocks.get(key);
    }
}
