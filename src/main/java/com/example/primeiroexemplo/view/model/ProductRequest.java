package com.example.primeiroexemplo.view.model;

public class ProductRequest {
    
        //#region
        private String name;
    
        private Integer amount;
    
        private Double value;
    
        private String observation;
        // #endregion
    
        // #region Getters and Setters
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public Integer getAmount() {
            return amount;
        }
    
        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    
        public Double getValue() {
            return value;
        }
    
        public void setValue(Double value) {
            this.value = value;
        }
    
        public String getObservation() {
            return observation;
        }
    
        public void setObservation(String observation) {
            this.observation = observation;
        }
        // #endregion
    
}
