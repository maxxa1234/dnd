package com.nechinc.dnd.character.constant;

import com.nechinc.dnd.character.model.Skill;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SkillConst {
        public static Map<String, Set<Skill>> getClassSkillMap() {
                Map<String, Set<Skill>> classSkills = new HashMap<>();

                classSkills.put("barbarian", Set.of(
                        Skill.ANIMAL_HANDLING, Skill.ATHLETICS, Skill.INTIMIDATION,
                        Skill.NATURE, Skill.PERCEPTION, Skill.SURVIVAL
                ));

                classSkills.put("bard", Set.of(Skill.values())); // Bard can choose any skills

                classSkills.put("cleric", Set.of(
                        Skill.HISTORY, Skill.INSIGHT, Skill.MEDICINE,
                        Skill.PERSUASION, Skill.RELIGION
                ));

                classSkills.put("druid", Set.of(
                        Skill.ANIMAL_HANDLING, Skill.ARCANA, Skill.INSIGHT,
                        Skill.MEDICINE, Skill.NATURE, Skill.PERCEPTION,
                        Skill.RELIGION, Skill.SURVIVAL
                ));

                classSkills.put("fighter", Set.of(
                        Skill.ACROBATICS, Skill.ANIMAL_HANDLING, Skill.ATHLETICS,
                        Skill.HISTORY, Skill.INSIGHT, Skill.INTIMIDATION,
                        Skill.PERCEPTION, Skill.SURVIVAL
                ));

                classSkills.put("monk", Set.of(
                        Skill.ACROBATICS, Skill.ATHLETICS, Skill.HISTORY,
                        Skill.INSIGHT, Skill.RELIGION, Skill.STEALTH
                ));

                classSkills.put("paladin", Set.of(
                        Skill.ATHLETICS, Skill.INSIGHT, Skill.INTIMIDATION,
                        Skill.MEDICINE, Skill.PERSUASION, Skill.RELIGION
                ));

                classSkills.put("ranger", Set.of(
                        Skill.ANIMAL_HANDLING, Skill.ATHLETICS, Skill.INSIGHT,
                        Skill.INVESTIGATION, Skill.NATURE, Skill.PERCEPTION,
                        Skill.STEALTH, Skill.SURVIVAL
                ));

                classSkills.put("rogue", Set.of(
                        Skill.ACROBATICS, Skill.ATHLETICS, Skill.DECEPTION,
                        Skill.INSIGHT, Skill.INTIMIDATION, Skill.INVESTIGATION,
                        Skill.PERCEPTION, Skill.PERFORMANCE, Skill.PERSUASION,
                        Skill.SLEIGHT_OF_HAND, Skill.STEALTH
                ));

                classSkills.put("sorcerer", Set.of(
                        Skill.ARCANA, Skill.DECEPTION, Skill.INSIGHT,
                        Skill.INTIMIDATION, Skill.PERSUASION, Skill.RELIGION
                ));

                classSkills.put("warlock", Set.of(
                        Skill.ARCANA, Skill.DECEPTION, Skill.HISTORY,
                        Skill.INTIMIDATION, Skill.INVESTIGATION,
                        Skill.NATURE, Skill.RELIGION
                ));

                classSkills.put("wizard", Set.of(
                        Skill.ARCANA, Skill.HISTORY, Skill.INSIGHT,
                        Skill.INVESTIGATION, Skill.MEDICINE, Skill.RELIGION
                ));

                return classSkills;
        }

        public static Map<String, Integer> getClassSkillCountMap() {
                Map<String, Integer> classSkillCount = new HashMap<>();

                classSkillCount.put("barbarian", 2);
                classSkillCount.put("bard", 3);
                classSkillCount.put("cleric", 2);
                classSkillCount.put("druid", 2);
                classSkillCount.put("fighter", 2);
                classSkillCount.put("monk", 2);
                classSkillCount.put("paladin", 2);
                classSkillCount.put("ranger", 3);
                classSkillCount.put("rogue", 4);
                classSkillCount.put("sorcerer", 2);
                classSkillCount.put("warlock", 2);
                classSkillCount.put("wizard", 2);

                return classSkillCount;
        }
}
