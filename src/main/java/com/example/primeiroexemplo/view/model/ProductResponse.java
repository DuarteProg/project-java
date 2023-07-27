package com.example.primeiroexemplo.view.model;

public class ProductResponse {
      
    //#region
        private Integer id;

        private String name;
    
        private Integer amount;
    
        private Double value;
    
        private String observation;
        // #endregion
    
        // #region Getters and Setters
        public Integer getId() {
            return id;
        }
    
        public void setId(Integer id) {
            this.id = id;
        }
    
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
