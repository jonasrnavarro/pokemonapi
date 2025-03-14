package com.exam.pokemonapi.dto;

import java.util.List;

public class PokemonDTO {

    private int id;
    private String name;
    private List<Type> types;
    private List<Move> moves;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class Type {
        private TypeDetail type;

        public TypeDetail getType() {
            return type;
        }

        public void setType(TypeDetail type) {
            this.type = type;
        }

        public static class TypeDetail {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class Move {
        private MoveDetail move;

        public MoveDetail getMove() {
            return move;
        }

        public void setMove(MoveDetail move) {
            this.move = move;
        }

        public static class MoveDetail {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
