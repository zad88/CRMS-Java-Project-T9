class ProcessedRecord extends BookingRecord {
        private InsuranceOption insuranceOption;
        private Discount discount;
        private double finalCost;

        // Constructor
        public ProcessedRecord(BookingRecord br,
                               InsuranceOption insuranceOption,
                               Discount discount) {

            // Call parent constructor
            super(br.getClient(), br.getCar(), br.getAgent(),
                    br.getStartDate(), br.getEndDate(), br.getBaseCost());

            this.insuranceOption = insuranceOption;
            this.discount = discount;

            calculateFinalCost();
        }

        // Cost calculation logic
        private void calculateFinalCost() {
            double cost = getBaseCost();

            // Add insurance
            if (insuranceOption != null) {
                cost += insuranceOption.getCost();
            }

            // Apply discount
            if (discount != null) {
                cost -= cost * (discount.getPercentage() / 100);
            }

            this.finalCost = cost;
        }

        // Getters
        public InsuranceOption getInsuranceOption() {
            return insuranceOption;
        }

        public Discount getDiscount() {
            return discount;
        }

        public double getFinalCost() {
            return finalCost;
        }

        // Optional: nice display
        @Override
        public String toString() {
            return "ProcessedRecord{" +
                    "client=" + getClient().getName() +
                    ", car=" + getCar().getModel() +
                    ", agent=" + getAgent().getName() +
                    ", baseCost=" + getBaseCost() +
                    ", insurance=" + (insuranceOption != null ? insuranceOption.getType() : "None") +
                    ", discount=" + (discount != null ? discount.getType() : "None") +
                    ", finalCost=" + finalCost +
                    '}';
        }
    }

