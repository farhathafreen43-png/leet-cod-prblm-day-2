class UndergroundSystem {
    Map<Integer, Object[]> checkIn = new HashMap<>();
    Map<String, double[]> travel = new HashMap<>();

    public void checkIn(int id, String station, int t) {
        checkIn.put(id, new Object[]{station, t});
    }

    public void checkOut(int id, String station, int t) {
        Object[] info = checkIn.remove(id);
        String key = info[0] + "_" + station;
        travel.putIfAbsent(key, new double[2]);
        travel.get(key)[0] += t - (int) info[1];
        travel.get(key)[1]++;
    }

    public double getAverageTime(String start, String end) {
        double[] d = travel.get(start + "_" + end);
        return d[0] / d[1];
    }
}
