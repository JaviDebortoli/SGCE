package SGCE.domain;

import java.util.Set;

public enum EnrollmentStatus {
    ACTIVE {
        @Override
        public Set<EnrollmentStatus> allowedTransitions() {
            return Set.of(FINISHED, CANCELLED);
        }
    },

    FINISHED {
        @Override
        public Set<EnrollmentStatus> allowedTransitions() {
            return Set.of(); // estado terminal
        }
    },

    CANCELLED {
        @Override
        public Set<EnrollmentStatus> allowedTransitions() {
            return Set.of(); // estado terminal
        }
    };

    public abstract Set<EnrollmentStatus> allowedTransitions();

    public boolean canTransitionTo(EnrollmentStatus target) {
        return allowedTransitions().contains(target);
    }
}