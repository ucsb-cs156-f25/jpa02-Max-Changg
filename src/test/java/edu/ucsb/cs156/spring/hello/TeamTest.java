package edu.ucsb.cs156.spring.hello;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equality_same_object() {
        assertEquals(team, team);
    }
    @Test
    public void equality_different_instance_object() {
        assert(!team.equals(1));
    }
    @Test
    public void equality_same_instance() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Max");
        members.add("Joe");
        Team team2 = new Team("temp");


        assertEquals(false, team.equals(team2)); // F name, T members
        team2.setName("test-team");
        assertEquals(true, team.equals(team2)); // T name, T members
        team.setMembers(members);

        assertEquals(false, team.equals(team2)); // T name, F Members
        team2.setMembers(members);
        assertEquals(true, team.equals(team2)); // T name, T Members
    }

    @Test
    public void hash_equality() {
           Team t1 = new Team();
            t1.setName("foo");
            t1.addMember("bar");
            Team t2 = new Team();
            t2.setName("foo");
            t2.addMember("bar");
            assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void hash_mutation_workaround() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
