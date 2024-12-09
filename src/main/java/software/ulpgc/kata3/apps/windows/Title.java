package software.ulpgc.kata3.apps.windows;

public class Title {
    private final String id;
    private final TitleType titleType;
    private final int startyear;

    public Title(String id, TitleType titleType, int startyear) {
        this.id = id;
        this.titleType = titleType;
        this.startyear = startyear;
    }


    public TitleType getTitleType() {
        return titleType;
    }

    public int getStartyear() {
        return startyear;
    }

    public enum TitleType {
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode
    }

    public enum Genre {
        Action, Adult, Adventure, Animation, Biography, Comedy, Crime, Documentary, Drama, Family, Fantasy, FilmNoir, GameShow, genres, History, Horror, Music, Musical, Mystery, News, RealityTV, Romance, SciFi, Short, Sport, TalkShow, Thriller, War, Western
    }

}
