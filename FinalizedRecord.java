class FinalizedRecord extends ProcessedRecord {

    private PaymentDetails paymentDetails;
    private PickupDetails pickupDetails;

        public FinalizedRecord(ProcessedRecord pr,
                               PaymentDetails paymentDetails,
                               PickupDetails pickupDetails) {

            // Call parent constructor
            super(pr, pr.getInsuranceOption(), pr.getDiscount());

            this.paymentDetails = paymentDetails;
            this.pickupDetails = pickupDetails;
        }

        public PaymentDetails getPaymentDetails() {
            return paymentDetails;
        }

        public PickupDetails getPickupDetails() {
            return pickupDetails;
        }

        @Override
        public String toString() {
            return "FinalizedRecord{" +
                    "client=" + getClient().getName() +
                    ", car=" + getCar().getModel() +
                    ", finalCost=" + getFinalCost() +
                    ", deposit=" + paymentDetails.getDeposit() +
                    ", remaining=" + paymentDetails.getRemainingBalance() +
                    ", pickupBranch=" + pickupDetails.getBranch() +
                    '}';
        }
    }

