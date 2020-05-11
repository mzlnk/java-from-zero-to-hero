public class Address {

    // required
    private String country;
    private String city;
    private String street;

    // optional
    private int streetNumber;
    private int flatNumber;

    private boolean secondaryAddress;

    private Address(AddressBuilder builder) {
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.streetNumber = builder.streetNumber;
        this.flatNumber = builder.flatNumber;
        this.secondaryAddress = builder.secondaryAddress;
    }

    @Override
    public String toString() {
        return "Address[country=?,city=?,street=?,streetNumber=?,flatNumber=?,secondaryAddress=?"
                .replaceFirst("\\?", this.country)
                .replaceFirst("\\?", this.city)
                .replaceFirst("\\?", this.street)
                .replaceFirst("\\?", String.valueOf(this.streetNumber))
                .replaceFirst("\\?", String.valueOf(this.flatNumber))
                .replaceFirst("\\?", String.valueOf(this.secondaryAddress));
    }

    public static class AddressBuilder {

        // required
        private String country;
        private String city;
        private String street;

        // optional
        private int streetNumber;
        private int flatNumber;

        private boolean secondaryAddress;

        public AddressBuilder(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public AddressBuilder withStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder withFlatNumber(int flatNumber) {
            this.flatNumber = flatNumber;
            return this;
        }

        public AddressBuilder withSecondaryAddress(boolean secondaryAddress) {
            this.secondaryAddress = secondaryAddress;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }


}
