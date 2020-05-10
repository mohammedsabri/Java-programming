package sample;

public class Property {

    private static int propertyId = 0;
    private int id;
    private String description;
    private String address;
    private String category;
    private String town;
    private String ber;
    private String eircode;
    private int price;
    private String agentName;
    private int phoneNumber;
    private String PriceMin;
    private String PriceMix;

    public Property(int id, String description, String address, String category, String town, String ber, String eircode, int price, String agentName, int phoneNumber, String priceMin, String priceMix) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.category = category;
        this.town = town;
        this.ber = ber;
        this.eircode = eircode;
        this.price = price;
        this.agentName = agentName;
        this.phoneNumber = phoneNumber;
        PriceMin = priceMin;
        PriceMix = priceMix;
    }

    public static int getPropertyId() {
        return propertyId;
    }

    public static void setPropertyId(int propertyId) {
        Property.propertyId = propertyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getBer() {
        return ber;
    }

    public void setBer(String ber) {
        this.ber = ber;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPriceMin() {
        return PriceMin;
    }

    public void setPriceMin(String priceMin) {
        PriceMin = priceMin;
    }

    public String getPriceMix() {
        return PriceMix;
    }

    public void setPriceMix(String priceMix) {
        PriceMix = priceMix;
    }

    @Override
    public String toString() {
        return "Property "   +

                "id: " +  id
               + ",  description:  " +    description
               + ", address:  " + address
               + ", category:  " + category
               + ", town:  " + town
               + ", ber:  " + ber
                +", eircode:  "   + eircode
               + ", price:  "   +  price
               + ", agentName:  "  +  agentName
               + ", phoneNumber:  "  +  phoneNumber ;
    }
}
