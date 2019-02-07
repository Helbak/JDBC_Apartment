package apartmentsJDBC;


public class ToSQL {
    private RequestJDBC rj;

    public ToSQL() {
    }

    public String toSQL(RequestJDBC rj) {
        String where = "";
        String district = "";
        String nRoom = "";
        String andOne = "";
        String andTwo = "";
        String from = "";

        if (rj.getnRoom() == 4 && rj.getDistrict() == 4 && rj.getFrom() == 3)
            where = "";
        if (rj.getDistrict() == 1)
            district = " DISTRICT='Obolon' ";
        if (rj.getDistrict() == 2)
            district = " DISTRICT='Center' ";
        if (rj.getDistrict() == 3)
            district = " DISTRICT='Nivki' ";
        if (rj.getDistrict() == 4)
            district = "";


        if (rj.getnRoom() == 1)
            nRoom = " N_ROOM=1 ";
        if (rj.getnRoom() == 2)
            nRoom = " N_ROOM=2 ";
        if (rj.getnRoom() == 3)
            nRoom = " N_ROOM=3 ";
        if (rj.getnRoom() == 4)
            nRoom = "";

        if (rj.getFrom() == 3)
            from = " ISAGENT = 'AGENT' ";
        if (rj.getFrom() == 2)
            from = "ISAGENT = 'OWNER' ";
        if (rj.getFrom() == 1)
            from = "";


        if (district!="" || nRoom!="" || from!=""){
            where = "WHERE";
        }

        if (district!="" && nRoom!="" && from==""){
            andOne = " AND ";
        }
        if (district!="" && nRoom=="" && from!=""){
            andOne = " AND ";
        }
        if (district!="" || nRoom!="" && from!=""){
            andTwo = " AND ";
        }
        if (andOne!=""){
            andTwo = "";
        }

            String sql = "SELECT FLATS.*, SELLER.FIO_SELLER, SELLER.PHONE, SELLER.ISAGENT " +
                    "FROM FLATS LEFT JOIN SELLER ON FLATS.SELLER_ID=SELLER.ID " +
                    where + district + andOne + nRoom + andTwo + from + ";";
        return sql;
    }
}
