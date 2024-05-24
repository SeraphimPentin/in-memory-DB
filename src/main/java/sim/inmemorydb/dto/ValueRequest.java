package sim.inmemorydb.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ValueRequest {

        private Double value;

        public Double getValue() {
                return value;
        }

        public void setValue(Double value) {
                this.value = value;
        }
}
