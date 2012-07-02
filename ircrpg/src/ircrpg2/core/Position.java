/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ircrpg2.core;



/**
 *
 * @author testi
 */
public class Position {

    private Location location;
    private Locality start;
    private Locality destination;
    private double progress;

    public Location getLocation() {
        return location;
    }

    public Locality getStart() {
        return start;
    }

    public Locality getDestination() {
        return destination;
    }

    public double getProgress() {
        return progress;
    }

    public Position(Locality location) {
        this.location = location;
        start = null;
        destination = null;
        progress = 0;
    }

    public Position(Path location, Locality start, Locality destination, double progress) {
        this.location = location;
        this.start = start;
        this.destination = destination;
        if (progress < 0) {
            this.progress = 0;
        } else if (progress > 1) {
            progress = 1;
        } else {
            this.progress = progress;
        }
    }

    public boolean equals(Position position) {
        if (position == null) {
            return false;
        }
        if (this == position) {
            return true;
        }
        if (isOnPath()) {
            if (this.location == position.location) {
                if (this.start == position.start && this.destination == position.destination && this.progress == position.progress) {
                    return true;
                }
                if (this.destination == position.start && this.start == position.destination && 1 - this.progress == position.progress) {
                    return true;
                }
            }
        } else {
            return (this.location == position.location);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (isOnPath()) {
            return location.hashCode() + start.hashCode() + destination.hashCode();
        } else {
            return location.hashCode();
        }
    }

    public boolean isOnPath() {
        return (location instanceof Path);
    }

    public double getDistance(Position position) {
        if (this == position) {
            return 0.0;
        }
        if (isOnPath()) {
            if (this.location == position.location) {
                if (this.start == position.start && this.destination == position.destination) {
                    double distance = ((Path) location).getLength() * (this.progress - position.progress);
                    if (distance < 0) {
                        distance = -distance;
                    }
                    return distance;
                }
                if (this.destination == position.start && this.start == position.destination) {
                    double distance = ((Path) location).getLength() * ((1 - this.progress) - position.progress);
                    if (distance < 0) {
                        distance = -distance;
                    }
                    return distance;
                }
            }
            if (!position.isOnPath()) {
            if (this.destination == position.location) {
            return (1-progress) * ((Path)location).getLength();
            }
            else if (this.start == position.location) {
            return progress * ((Path)location).getLength();
            }
            
            }
            }

        else if (this.location == position.location) {
            return 0.0;
        } else if (position.isOnPath()) {
            return position.getDistance(this);
        } else {
        Path connecting = ((Locality)this.location).getPathTo((Locality)position.location);
        if (connecting != null) return connecting.getLength();
        }
        return Double.MAX_VALUE; //Means: distance information not available

    }
}
