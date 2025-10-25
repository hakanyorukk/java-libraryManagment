public enum Genre {
    PROGRAMMING,
    FANTASY,
    DYSTOPIAN_FICTION,
    FICTION,
    COMPUTER_SCIENCE,
    CLASSIC_FICTION;

    public static Genre fromString(String genre) {
        String normalized = genre.toUpperCase().replace(" ", "_");
        return Genre.valueOf(normalized);
    }
}
